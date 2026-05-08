FROM node:20 AS build

WORKDIR /app

COPY . .

RUN npm install

RUN npx ng build



FROM nginx:alpine

RUN rm -rf /usr/share/nginx/html/*

COPY --from=build /app/dist/frontend-my-web-portafoglio/browser/ /usr/share/nginx/html

EXPOSE 80

CMD [ "nginx", "-g", "daemon off;" ]