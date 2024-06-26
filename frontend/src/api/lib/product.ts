import axiosClient from "../apiClient";

export function getProduct() {
  return axiosClient.get("/products");
}

export function getProductById(id: number) {
  return axiosClient.get(`/products/${id}`);
}

// export function addProduct(data) {
//   return axiosClient.post("/product", JSON.stringify(data));
// }
