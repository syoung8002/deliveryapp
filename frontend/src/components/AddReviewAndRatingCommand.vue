<template>
    <v-card outlined>
        <v-card-title>
            AddReviewAndRating
        </v-card-title>

        <v-card-text>
            <String label="OrderId" v-model="value.orderId" :editMode="editMode"/>
            <String label="Review" v-model="value.review" :editMode="editMode"/>
            <Number label="Rating" v-model="value.rating" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="addReviewAndRating"
            >
                AddReviewAndRating
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
        name: 'AddReviewAndRatingCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.orderId = '';
            this.value.review = '';
            this.value.rating = 0;
        },
        watch: {
        },
        methods: {
            addReviewAndRating() {
                this.$emit('addReviewAndRating', this.value);
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

