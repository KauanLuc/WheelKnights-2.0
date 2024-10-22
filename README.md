# WheelKnights-2.0

<img src="frontend/public/assets/img/wheelknightslogo.png" alt="Logo WheelKnights">

Este repositório contém a versão 2.0 do backend do projeto [WheelKnights](https://github.com/KauanLuc/WheelKnights). Esta versão é uma reimaginação do backend, implementada com Java Spring Boot para fornecer uma API REST, voltada ao cadastro de miniaturas de carros para colecionadores. 

> Além disso, o projeto inclui uma dashboard com informações detalhadas sobre a coleção e uma página inspirada em álbuns de revistas de miniaturas, onde a própria coleção se torna o álbum.

### Features

- [x] Cadastro de miniaturas de automóveis 
- [x] Dashboard de visualização dos dados da coleção
- [x] Página inspirada em álbuns de revistas de miniaturas, transformando a coleção em um álbum digital

## Pré-requisitos
 - `curl` instalado na sua máquina
 - `Docker` e `docker-compose` instalados na sua máquina

## Instalando WheelKnights-2.0
Para instalar o WheelKnights-2.0, siga estas etapas:

Navegue para o seu diretório de destino:

`
cd /caminho/diretorio/de/destino
`

Agora, instale o arquivo `docker-compose.yml` do projeto no seu diretório:

```bash
curl -L -o wheelknights-compose.yml https://raw.githubusercontent.com/KauanLuc/WheelKnights-2.0/refs/heads/main/docker-compose.yml
```

## Usando WheelKnights-2.0

Compile e rode o arquivo recém-instalado:

  ```bash
  docker-compose -f wheelknights-compose.yml up --build -d
  ```

Caso queira compilar em primeiro plano:

```bash
docker-compose -f wheelknights-compose.yml up --build
```

Acesse via navegador a URL `http://localhost:3000/`

## Parando WheelKnights-2.0

Para parar a aplicação, interrompa o servidor:

   ```bash
    docker-compose -f wheelknights-compose.yml stop
   ```

## LICENÇA

Licenciado sob a Licença MIT. Veja [LICENSE](https://github.com/KauanLuc/WheelKnights-2.0/blob/main/LICENSE) para mais informações.
