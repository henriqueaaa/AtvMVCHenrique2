# Biblioteca

Sistema de biblioteca feito com Spring Boot e Thymeleaf.

**Autor:** Henrique

## Funcionalidades
- Cadastrar livros (título, autor, ISBN)
- Listar livros
- Remover livros

Os livros ficam numa lista em memória no `LivroController`, então são perdidos ao reiniciar a aplicação.

## Como rodar
Requer Java 21.

```bash
./mvnw spring-boot:run
```

Acesse http://localhost:8080/livros
