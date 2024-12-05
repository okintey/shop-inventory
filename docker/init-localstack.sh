#!/bin/bash
# Create SQS queue
awslocal --endpoint-url=http://localhost:4566 sqs create-queue --queue-name shop-inventory-events-local
