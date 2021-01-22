FROM debian:buster

ARG MAVEN_VERSION=3.6.3
ARG SHA=c35a1803a6e70a126e80b2b3ae33eed961f83ed74d18fcd16909b2d44d7dada3203f1ffe726c17ef8dcca2dcaa9fca676987befeadc9b9f759967a8cb77181c0
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

ARG USERNAME=vscode
ARG USER_UID=1000

ENV MAVEN_HOME /opt/maven
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64

RUN apt update \
    && apt install -y sudo wget git openjdk-11-jdk openjdk-11-source openjdk-11-doc \
    && useradd -s /bin/bash --uid ${USER_UID} -m ${USERNAME} \
    && echo "${USERNAME} ALL=(root) NOPASSWD:ALL" > /etc/sudoers.d/${USERNAME} \
    && chmod 0440 /etc/sudoers.d/${USERNAME} \
    && mkdir ${MAVEN_HOME} \
    && wget --no-verbose --output-document=/tmp/apache-maven.tar.gz "${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
    && tar -xzf /tmp/apache-maven.tar.gz -C ${MAVEN_HOME} --strip-components=1 \
    && rm -f /tmp/apache-maven.tar.gz \
    && ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

CMD ["java"]
