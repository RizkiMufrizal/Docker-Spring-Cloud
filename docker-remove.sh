docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
rm -rf /tmp/consul_data_1