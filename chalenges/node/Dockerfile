FROM node

WORKDIR /usr/src/app

COPY . .

EXPOSE 3000

RUN npm install

ENTRYPOINT [ "npm", "start" ]