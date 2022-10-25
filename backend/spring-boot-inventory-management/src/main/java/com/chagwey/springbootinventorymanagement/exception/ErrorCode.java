package com.chagwey.springbootinventorymanagement.exception;

public enum ErrorCode {
	
	ARTICLE_NOT_FOUND ( 1000 ) ,
	ARTICLE_NOT_VALID ( 1001 ) ,
	
	CATEGORY_NOT_FOUND ( 2000 ) ,
	CATEGORY_NOT_VALID ( 2001 ) ,
	
	COMPANY_NOT_FOUND ( 3000 ) ,
	COMPANY_NOT_VALID ( 3001 ) ,
	
	USER_NOT_FOUND ( 4000 ) ,
	USER_NOT_VALID ( 4001 ) ,

	
	CLIENT_NOT_FOUND ( 5000 ) ,
	CLIENT_NOT_VALID ( 5001 ) ,
	
	VENDOR_NOT_FOUND ( 6000 ) ,
	VENDOR_NOT_VALID ( 6001 ) ,
	
	SALE_NOT_FOUND ( 7000 ) ,
	SALE_NOT_VALID ( 7001 ) ,
	
	CLIENT_ORDER_NOT_FOUND ( 8000 ) ,
	CLIENT_ORDER_NOT_VALID ( 8001 ) ,
	
	VENDOR_ORDER_NOT_FOUND ( 9000 ) ,
	VENDOR_ORDER_NOT_VALID ( 9001 ) ,
	
	CLIENT_ORDER_ITEM_NOT_FOUND ( 10000 ) ,
	
	VENDOR_ORDER_ITEM_NOT_FOUND ( 11000 ) ,
	
	SALE_ITEM_NOT_FOUND ( 12000 ) ,

	STK_MVT_NOT_FOUND ( 13000 ) ,
	STK_MVT_NOT_VALID ( 13001 ) ,
	;
	
	private int code;

	ErrorCode ( int code ) {
	  this.code= code ;
	}
	public int getCode ( ) {
	  return code ;
	}

}
