<template>
    <v-card outlined>
        <v-card-title>
            AddReview
        </v-card-title>

        <v-card-text>
            <String label="ReviewId" v-model="value.reviewId" :editMode="editMode"/>
            <String label="Review" v-model="value.review" :editMode="editMode"/>
            <OrderId offline label="OrderId" v-model="value.orderId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="addReview"
            >
                AddReview
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
        name: 'AddReviewCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.reviewId = '';
            this.value.review = '';
            this.value.orderId = {};
        },
        watch: {
        },
        methods: {
            addReview() {
                this.$emit('addReview', this.value);
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

