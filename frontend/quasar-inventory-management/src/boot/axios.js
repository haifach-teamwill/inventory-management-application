import { boot } from "quasar/wrappers";
import axios from "axios";
const api = axios.create({
  baseURL: "http://localhost:8070/inventory-management",
});
export default boot(({ app }) => {
  // for use inside Vue files ( Options API ) through this . $ axios and this . Sapi
});
app.config.globalProperties.Saxios = axios;

export { axios, api };
