# Docker

## O que é docker?

- É uma plataforma open source que facilita a criação de ambientes de sistemas isolados
- Possibilita o enpacotamento do projeto em containers
- O docker utiliza containers que permite portabilidade 

## Principais comandos utilizados

- Executa um container 

```bash
docker run hello-world
```

- Inicia um container

```bash
docker start <id>
```

- Para um container

```bash
docker stop <id>
```

- Remove um container

```bash
docker rm <id>
```

- Remove um container mesmo estando em execução

```bash
docker rm -f <id>
```

- Remove container não utilizados

```bash
docker rm $(docker container ls -a -q)
```