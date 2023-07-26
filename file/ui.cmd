docker stop selenoid-ui
docker rm selenoid-ui
docker run -d --name selenoid-ui -p 8080:8080 aerokube/selenoid-ui:latest-release --selenoid-uri http://172.24.160.1:8888 --webdriver-uri http://172.24.160.1:4444
