package com.chagwey.springbootinventorymanagement.service.impl;

import com.chagwey.springbootinventorymanagement.exception.EntityNotFoundException;
import com.chagwey.springbootinventorymanagement.exception.ErrorCode;
import com.chagwey.springbootinventorymanagement.exception.InvalidEntityException;
import com.chagwey.springbootinventorymanagement.model.Article;
import com.chagwey.springbootinventorymanagement.model.Client;
import com.chagwey.springbootinventorymanagement.model.ClientOrder;
import com.chagwey.springbootinventorymanagement.repository.ArticleRepository;
import com.chagwey.springbootinventorymanagement.repository.ClientOrderItemRepository;
import com.chagwey.springbootinventorymanagement.repository.ClientOrderRepository;
import com.chagwey.springbootinventorymanagement.repository.ClientRepository;
import com.chagwey.springbootinventorymanagement.service.ClientOrderService;
import com.chagwey.springbootinventorymanagement.validator.ClientOrderValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientOrderServiceImpl implements ClientOrderService {

    private ClientOrderRepository clientOrderRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private ClientOrderItemRepository clientOrderItemRepository;

    @Autowired
    public ClientOrderServiceImpl(ClientOrderRepository clientOrderRepository,
                                  ClientRepository clientRepository,
                                  ArticleRepository articleRepository,
                                  ClientOrderItemRepository clientOrderItemRepository) {
        this.clientOrderRepository = clientOrderRepository;
        this.clientOrderItemRepository = clientOrderItemRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ClientOrder> findAll() {
        return clientOrderRepository.findAll();
    }

    @Override
    public ClientOrder findById(Integer id) {
        if (id == null) {
            log.error("Commande client ID is null");
            return null;
        }
        return clientOrderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "No client order with id " + id + " was found.",
                ErrorCode.CLIENT_ORDER_NOT_FOUND));
    }

    @Override
    public ClientOrder save(ClientOrder clientOrder) {

        List<String> errors = ClientOrderValidator.validate(clientOrder);
        if (!errors.isEmpty()) {
            log.error("Client order is not valid");
//            we already verified that the client is not null, (client field exists inside client order object)
//            else will throw nullPointerException null.getId
            throw new InvalidEntityException("Order client is not valid", ErrorCode.CLIENT_ORDER_NOT_VALID, errors);
        }
//        client id can be null
        Optional<Client> client = clientRepository.findById(clientOrder.getClient().getId());
        if (client.isEmpty()) {
            log.warn("No client with ID {} was found.", client.get().getId());
            throw new EntityNotFoundException("No client with " + client.get().getId() + " was found.", ErrorCode.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();
//        clientOrderItems can be null, we can create a client order without items and modify it in another time
//        if we have client order items to save
        if (clientOrder.getClientOrderItems() != null) {


            clientOrder.getClientOrderItems().forEach(
                    clientOrderItem -> {
                        if (clientOrderItem.getArticle() != null) {
                            Optional<Article> article = articleRepository.findById(clientOrderItem.getArticle().getId());
                            if (article.isEmpty()) {
                                articleErrors.add("No article with " + article.get().getId() + " was found.");

                            }
                        } else {
                            articleErrors.add("Cannot save the order with a null article");

                        }
                    }
            );
        }
        if (!articleErrors.isEmpty()) {
            log.info("articlesErrors contain errors");
            throw new EntityNotFoundException("No article was found.", ErrorCode.ARTICLE_NOT_FOUND, articleErrors);
        }

        ClientOrder newClientOrder = clientOrderRepository.save(clientOrder);


        if (clientOrder.getClientOrderItems() != null) {
            clientOrder.getClientOrderItems().forEach(
                    clientOrderItem -> {
                        clientOrderItem.setClientOrder(newClientOrder);
                        clientOrderItemRepository.save(clientOrderItem);
                    }
            );
        }
        return newClientOrder;
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Commande client ID is null");
            clientOrderRepository.deleteById(id);
        }

    }
}
