
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrdermanagementOrderManager from "./components/listers/OrdermanagementOrderCards"
import OrdermanagementOrderDetail from "./components/listers/OrdermanagementOrderDetail"

import DeliverymatchingDriverManager from "./components/listers/DeliverymatchingDriverCards"
import DeliverymatchingDriverDetail from "./components/listers/DeliverymatchingDriverDetail"

import PaymentProcessingPaymentManager from "./components/listers/PaymentProcessingPaymentCards"
import PaymentProcessingPaymentDetail from "./components/listers/PaymentProcessingPaymentDetail"

import ReviewManagementReviewManager from "./components/listers/ReviewManagementReviewCards"
import ReviewManagementReviewDetail from "./components/listers/ReviewManagementReviewDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/ordermanagements/orders',
                name: 'OrdermanagementOrderManager',
                component: OrdermanagementOrderManager
            },
            {
                path: '/ordermanagements/orders/:id',
                name: 'OrdermanagementOrderDetail',
                component: OrdermanagementOrderDetail
            },

            {
                path: '/deliverymatchings/drivers',
                name: 'DeliverymatchingDriverManager',
                component: DeliverymatchingDriverManager
            },
            {
                path: '/deliverymatchings/drivers/:id',
                name: 'DeliverymatchingDriverDetail',
                component: DeliverymatchingDriverDetail
            },

            {
                path: '/paymentProcessings/payments',
                name: 'PaymentProcessingPaymentManager',
                component: PaymentProcessingPaymentManager
            },
            {
                path: '/paymentProcessings/payments/:id',
                name: 'PaymentProcessingPaymentDetail',
                component: PaymentProcessingPaymentDetail
            },

            {
                path: '/reviewManagements/reviews',
                name: 'ReviewManagementReviewManager',
                component: ReviewManagementReviewManager
            },
            {
                path: '/reviewManagements/reviews/:id',
                name: 'ReviewManagementReviewDetail',
                component: ReviewManagementReviewDetail
            },




    ]
})
