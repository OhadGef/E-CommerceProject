post(new Route("/getPrice") {
    @Override
    public Object handle(Request request, Response response) {
        product product = new product();
        product.getIosPrice();
        product.getAndroidPrice();
        userDao.create(product);                        
        response.status(201); // 201 Created
     }
});