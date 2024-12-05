const kafka = require('kafka-node');

const Consumer = kafka.Consumer;
const client = new kafka.KafkaClient({ kafkaHost: 'localhost:9092' });
const consumer = new Consumer(
    client,
    [{ topic: 'deliveryapp' }],
    { autoCommit: true, fromOffset: true }
);

console.log('Listening to Kafka topic: deliveryapp');

consumer.on('message', function (message) {
    // console.log('Received message:', message);
    if (message && message.value) {
        const value = JSON.parse(message.value)
        console.log(value)
    }
});

consumer.on('error', function (err) {
    console.error('Error:', err);
});
