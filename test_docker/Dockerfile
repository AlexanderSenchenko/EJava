# FROM ubuntu:latest

# RUN apt-get update
# RUN apt-get install -y nginx
# RUN echo 'Hi, I am in your container' > /usr/share/nginx/html/index.html
# EXPOSE 80

# FROM ubuntu_vim_jdk:latest

FROM ubuntu_vim_jdk:latest

# RUN apt update
# RUN apt install default-jdk
RUN mkdir -p /home/test_java
WORKDIR /home/test_java
COPY . /home/test_java
RUN ls
RUN javac Hello.java
RUN java Hello

