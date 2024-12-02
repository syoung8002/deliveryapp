<template>
    <v-card outlined>
        <v-card-title>
            CompletePayment
        </v-card-title>

        <v-card-text>
            <String label="PaymentId" v-model="value.paymentId" :editMode="editMode"/>
            <Money offline label="Amount" v-model="value.amount" :editMode="editMode" @change="change"/>
            <String label="PaymentMethod" v-model="value.paymentMethod" :editMode="editMode"/>
            <paymentMethodType offline label="PaymentMethodType" v-model="value.paymentMethodType" :editMode="editMode" @change="change"/>
            <OrderId offline label="OrderId" v-model="value.orderId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="completePayment"
            >
                CompletePayment
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CompletePaymentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.paymentId = '';
            this.value.amount = {};
            this.value.paymentMethod = '';
            this.value.paymentMethodType = {};
            this.value.orderId = {};
        },
        watch: {
        },
        methods: {
            completePayment() {
                this.$emit('completePayment', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

