<template>
    <v-card outlined>
        <v-card-title>
            OrderAccept
        </v-card-title>

        <v-card-text>
            <OrderId offline label="OrderId" v-model="value.orderId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="orderAccept"
            >
                OrderAccept
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
        name: 'OrderAcceptCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.orderId = {};
        },
        watch: {
        },
        methods: {
            orderAccept() {
                this.$emit('orderAccept', this.value);
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

