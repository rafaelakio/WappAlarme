# Guia de Contribuição

Obrigado por considerar contribuir com este projeto! Este documento fornece diretrizes para contribuir.

## Código de Conduta

Este projeto adere ao [Código de Conduta](CODE_OF_CONDUCT.md). Ao participar, você concorda em manter um ambiente respeitoso e acolhedor.

## Como Posso Contribuir?

### Reportar Bugs

Encontrou um bug? Ajude-nos a melhorar!

- Verifique se o bug já não foi reportado nas [Issues](https://github.com/rafaelakio/WappAlarme/issues)
- Se não encontrar, [crie uma nova issue](https://github.com/rafaelakio/WappAlarme/issues/new?template=bug_report.md)
- Use o template de bug report
- Forneça o máximo de detalhes possível

### Sugerir Melhorias

Tem uma ideia para melhorar o projeto?

- Verifique se a sugestão já não existe nas [Issues](https://github.com/rafaelakio/WappAlarme/issues)
- [Crie uma nova issue](https://github.com/rafaelakio/WappAlarme/issues/new?template=feature_request.md)
- Use o template de feature request
- Descreva claramente a melhoria proposta

### Contribuir com Código

1. Fork o repositório
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Faça suas alterações
4. Commit suas mudanças seguindo o padrão Conventional Commits
5. Push para a branch (`git push origin feature/MinhaFeature`)
6. Abra um Pull Request

### Melhorar Documentação

- Corrija erros de digitação
- Melhore explicações
- Adicione exemplos

## Setup do Ambiente de Desenvolvimento

```bash
# Clone o repositório
git clone https://github.com/rafaelakio/WappAlarme.git
cd WappAlarme

# Compile o projeto
./gradlew build
```

## Padrões de Código (Kotlin)

- Siga as [convenções de código Kotlin](https://kotlinlang.org/docs/coding-conventions.html)
- Use nomes descritivos para classes e funções
- Prefira `val` sobre `var` quando possível
- Utilize KDoc para documentação

## Commits e Pull Requests

### Padrão de Commits (Conventional Commits)

Use o formato: `tipo(escopo): descrição`

**Tipos:**
- `feat`: Nova funcionalidade
- `fix`: Correção de bug
- `docs`: Documentação
- `style`: Formatação (não afeta código)
- `refactor`: Refatoração
- `test`: Testes
- `chore`: Manutenção

**Exemplos:**
```bash
feat(core): add new feature
fix(parser): resolve parsing bug
docs(readme): update installation instructions
test(utils): add unit tests
```

### Pull Requests

- Preencha o template de PR
- Descreva claramente as mudanças
- Referencie a issue relacionada
- Garanta que os testes passam

## Segurança

- Nunca commite senhas, tokens ou chaves
- Use variáveis de ambiente para dados sensíveis
- Reporte vulnerabilidades de forma privada (veja [SECURITY.md](SECURITY.md))

## Dúvidas?

- Abra uma [Discussion](https://github.com/rafaelakio/WappAlarme/discussions)
- Entre em contato via [Issues](https://github.com/rafaelakio/WappAlarme/issues)

---

Obrigado por contribuir! Cada contribuição é valiosa para o projeto.
