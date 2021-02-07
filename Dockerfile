FROM openjdk:11

MAINTAINER mykyta_kostiuk@epam.com

ARG SERVICES_DIR="/apps/services"
RUN mkdir -p $SERVICES_DIR
WORKDIR $SERVICES_DIR

ADD ./build/libs/store_app-0.0.1.jar $SERVICES_DIR
ADD docker-entrypoint.sh $SERVICES_DIR

RUN chmod +x $SERVICES_DIR/docker-entrypoint.sh

ENTRYPOINT ["./docker-entrypoint.sh"]