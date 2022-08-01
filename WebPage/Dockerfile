# taking care of copying installing image and running server
FROM mhart/alpine-node:16
EXPOSE 8081
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
# fetching spring boot image from own repo and starting it
#RUN apk add --update docker openrc
#RUN rc-update add docker boot
#RUN service docker start
#RUN apk add docker openrc
#RUN rc-update add docker boot
#RUN service docker start
#RUN docker run --rm -v /var/run/docker.sock:/var/run/docker.sock -p 9089:8080 enrogaj/web-game-repo:finalspring
CMD [ "node", "server.js" ]