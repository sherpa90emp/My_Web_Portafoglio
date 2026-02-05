FROM nginx:alpine

RUN rm -rf /usr/share/nginx/html/*

COPY dist/frontend-my-web-portafoglio/browser/ /usr/share/nginx/html

EXPOSE 80

CMD [ "nginx", "-g", "daemon off;" ]