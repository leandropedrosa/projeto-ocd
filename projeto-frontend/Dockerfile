FROM node:8.11.3-jessie as builder

COPY package.json package-lock.json ./

RUN npm set progress=false && npm config set depth 0 && npm cache clean --force

## Storing node modules on a separate layer will prevent unnecessary npm installs at each build
RUN npm i && mkdir /ng-app && cp -R ./node_modules ./ng-app

WORKDIR /ng-app

COPY . .

#ARG env=dev

## Build the angular app in production mode and store the artifacts in dist folder
#RUN $(npm bin)/ng build --prod --build-optimizer --configuration $env
RUN $(npm bin)/ng build --prod --build-optimizer

FROM nginx:mainline

## Copy our default nginx config
COPY nginx/default.conf /etc/nginx/conf.d/

## From 'builder' stage copy over the artifacts in dist folder to default nginx public folder
COPY --from=builder /ng-app/dist /usr/share/nginx/html

# support running as arbitrary user which belogs to the root group
RUN chmod g+rwx /var/cache/nginx /var/run /var/log/nginx

# users are not allowed to listen on priviliged ports
RUN sed -i.bak 's/listen\(.*\)80;/listen 8081;/' /etc/nginx/conf.d/default.conf

EXPOSE 8081

# comment user directive as master process is run as user in OpenShift anyhow
RUN sed -i.bak 's/^user/#user/' /etc/nginx/nginx.conf

RUN chmod 777 /usr/share/nginx/html/assets/environments

RUN addgroup nginx root

USER nginx

CMD /bin/sh -c "envsubst < /usr/share/nginx/html/assets/environments/environment.tpl.json > /usr/share/nginx/html/assets/environments/environment.json && nginx -g 'daemon off;'"
