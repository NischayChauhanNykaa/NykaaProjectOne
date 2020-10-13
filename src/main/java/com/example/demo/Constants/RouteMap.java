package com.example.demo.Constants;

public class RouteMap 
{ 

	/* Product Controller API Routes */
    public static final String PRODUCT_CONTROLLER = "/product";
    
    public static final String PRODUCT_CONTROLLER_GET_PRODUCT = "";
    public static final String PRODUCT_CONTROLLER_POST_PRODUCT = "";
    public static final String PRODUCT_CONTROLLER_PUT_PRODUCT = "";
    public static final String PRODUCT_CONTROLLER_DELETE_PRODUCT = "";
    
    public static final String PRODUCT_CONTROLLER_GET_PRODUCT_CATEGORY = "/category";
    public static final String PRODUCT_CONTROLLER_POST_PRODUCT_CATEGORY = "/category";
    public static final String PRODUCT_CONTROLLER_PUT_PRODUCT_CATEGORY = "/category";
    public static final String PRODUCT_CONTROLLER_DELETE_PRODUCT_CATEGORY = "/category";
    
    

	/* Order Controller API Routes */
    public static final String ORDER_CONTROLLER = "/order";
    public static final String ORDER_CONTROLLER_POST_ORDER = "";
    public static final String ORDER_CONTROLLER_POST_ORDER_DETAILS = "/details";
    public static final String ORDER_CONTROLLER_POST_ORDER_DETAILS_TRANSACTION = "/detail";
    public static final String ORDER_CONTROLLER_GET_ORDER_DETAILS = "/{id}";
    public static final String ORDER_CONTROLLER_GET_ORDERS_BY_EMAIL = "/myOrders";


    /* User Controller API Routes */
    public static final String USER_CONTROLLER = "/user";
    public static final String USER_CONTROLLER_REGISTER_USER = "/register";
    public static final String USER_CONTROLLER_LOGIN_USER = "/login";
    public static final String USER_CONTROLLER_GET_USER_DETAILS = "/{id}";
    public static final String USER_CONTROLLER_UPDATE_USER_DETAILS = "/update";
    public static final String USER_CONTROLLER_DELETE_USER = "/delete";
}