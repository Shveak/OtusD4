docker stop selenoid1
docker rm selenoid1
docker run -d --network selenoid1 --name selenoid1 -p 4445:4444 -v //var/run/docker.sock:/var/run/docker.sock -v /c/Users/AOleinik/.selenoid/:/etc/selenoid:ro aerokube/selenoid:latest-release -container-network=selenoid1 -limit=6

docker stop selenoid2
docker rm selenoid2
docker run -d --network selenoid2 --name selenoid2 -p 4446:4444 -v //var/run/docker.sock:/var/run/docker.sock -v /c/Users/AOleinik/.selenoid/:/etc/selenoid:ro aerokube/selenoid:latest-release -container-network=selenoid2 -limit=8

docker stop selenoid3
docker rm selenoid3
docker run -d --network selenoid3 --name selenoid3 -p 4447:4444 -v //var/run/docker.sock:/var/run/docker.sock -v /c/Users/AOleinik/.selenoid/:/etc/selenoid:ro aerokube/selenoid:latest-release -container-network=selenoid3 -limit=8

docker stop selenoid4
docker rm selenoid4
docker run -d --network selenoid4 --name selenoid4 -p 4448:4444 -v //var/run/docker.sock:/var/run/docker.sock -v /c/Users/AOleinik/.selenoid/:/etc/selenoid:ro aerokube/selenoid:latest-release -container-network=selenoid4 -limit=10
