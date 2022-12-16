# Networks

- É usado para conectar containers em uma mesma rede
- Algumas das redes mais utilizadas
    - Bridge
    - Local
    - Host 

## Trabalhando com bridge

- Inspeciona uma rede

```bash
docker network inspect bridge
```

- Remove networks não utilizadas

```bash
docker network prune
```

- Criando uma nova network

```bash
docker network create --driver bridge minharede 
```

- Executando um container com a network

```bash
docker run -dit --name ubuntu1 --network minharede bash
```

- Conecta uma rede a um container existente

```bash
docker network connect minharede ubuntu3
```

## Trabalhando com host

- Este tipo de conexão é usada quando queremos que o container docker utilize a mesma rede da máquina
- Exemplo de utilização

```bash
docker run --rm -d --name nginx --network host nginx
```

- Para que um ambiente docker acesse sua máquina, é necessário que o container utilize o host: host.docker.internal