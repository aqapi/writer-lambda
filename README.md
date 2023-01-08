# writer-service

## Deployment

This project uses GitHub Actions workflow. On every push to the main branch a container image is built and released to repository's Github Container Registry. During the next scheduled run the newest container image will be pulled by ECS.
