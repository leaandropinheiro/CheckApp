FROM node:23.3.0 AS build-front

RUN npm install -g http-server

RUN npm install -g pnpm

WORKDIR /checkapp-frontend

COPY /package.json .

RUN pnpm install

COPY . .

COPY .env .

RUN pnpm run build

EXPOSE 3000

CMD [ "http-server", "-p 3000" ,"dist" ]