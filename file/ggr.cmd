docker stop ggr
docker rm ggr
docker run -d --name ggr -p 4444:4444 -v /c/Users/AOleinik/.selenoid/grid-router/:/etc/grid-router:ro aerokube/ggr:latest-release -guests-allowed -guests-quota "test" -verbose -quotaDir /etc/grid-router/quota

docker stop ggr-ui
docker rm ggr-ui
docker run -d --name ggr-ui -p 8888:8888 -v /c/Users/AOleinik/.selenoid/grid-router/quota/:/etc/grid-router/quota:ro aerokube/ggr-ui:latest-release
