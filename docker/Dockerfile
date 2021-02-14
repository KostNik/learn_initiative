FROM openjdk:11-jre

MAINTAINER mykyta_kostiuk@epam.com

ARG SERVICES_DIR="/apps/services/"
RUN mkdir -p $SERVICES_DIR
WORKDIR $SERVICES_DIR

RUN echo $(ls -lah)
RUN echo $(pwd)

COPY store_app-0.0.1.jar docker-entrypoint.sh $SERVICES_DIR

RUN chmod +x ./docker-entrypoint.sh

ENTRYPOINT ["./docker-entrypoint.sh"]