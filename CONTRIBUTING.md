# Contributing to WappAlarme

Thank you for your interest in contributing to WappAlarme! This document provides comprehensive guidelines to help you contribute effectively in our open source project.

## Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Workflow](#development-workflow)
- [Coding Standards](#coding-standards)
- [Testing Guidelines](#testing-guidelines)
- [Documentation](#documentation)
- [Pull Request Process](#pull-request-process)
- [Issue Reporting](#issue-reporting)
- [Security](#security)

## Code of Conduct

This project follows the [Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md). Please read and follow it in all your interactions with the project.

## Getting Started

### Prerequisites

- Node.js 18 or higher
- npm or yarn
- Git
- Modern web browser
- IDE (VS Code recommended)

### Setup

1. Fork the repository
2. Clone your fork:
   ```bash
   git clone https://github.com/your-username/WappAlarme.git
   cd WappAlarme
   ```
3. Add the original repository as upstream:
   ```bash
   git remote add upstream https://github.com/original-owner/WappAlarme.git
   ```
4. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```

## Development Workflow

We follow the GitFlow branching model:

### Branch Structure

- `main`: Production-ready code
- `develop`: Integration branch for features
- `feature/*`: New features
- `release/*`: Release preparation
- `hotfix/*`: Critical fixes

### Workflow

1. **Create Feature Branch**
   ```bash
   git checkout develop
   git pull upstream develop
   git checkout -b feature/your-feature-name
   ```

2. **Develop and Test**
   - Write code following our coding standards
   - Add comprehensive tests
   - Ensure all tests pass

3. **Commit Changes**
   ```bash
   git add .
   git commit -m "feat: add your feature description"
   ```

4. **Push and Create PR**
   ```bash
   git push origin feature/your-feature-name
   ```

## Coding Standards

### JavaScript/TypeScript Guidelines

- Follow [ESLint recommended rules](https://eslint.org/docs/rules/)
- Use meaningful variable and function names
- Keep functions small and focused
- Add JSDoc comments for public APIs
- Use modern ES6+ features

### Code Style

```javascript
// Good
const getUserById = async (id) => {
  const user = await userRepository.findById(id);
  if (!user) {
    throw new Error(`User with id ${id} not found`);
  }
  return user;
};

// Bad
const getUser = async (id) => {
  const u = await userRepository.findById(id);
  return u;
};
```

### React Guidelines

- Use functional components with hooks
- Follow React best practices
- Implement proper error boundaries
- Use TypeScript for type safety
- Follow accessibility guidelines

### Architecture Guidelines

- Follow clean architecture principles
- Use proper state management
- Implement proper error handling
- Separate concerns properly

## Testing Guidelines

### Test Structure

```
src/
├── __tests__/
│   ├── unit/           # Unit tests
│   ├── integration/    # Integration tests
│   └── e2e/           # End-to-end tests
└── components/
    └── __tests__/       # Component tests
```

### Writing Tests

```javascript
import { render, screen } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import { UserCard } from './UserCard';

describe('UserCard', () => {
  const mockUser = {
    id: '1',
    name: 'John Doe',
    email: 'john@example.com'
  };

  it('should render user information correctly', () => {
    render(<UserCard user={mockUser} />);
    
    expect(screen.getByText('John Doe')).toBeInTheDocument();
    expect(screen.getByText('john@example.com')).toBeInTheDocument();
  });

  it('should handle click events', async () => {
    const onEdit = jest.fn();
    render(<UserCard user={mockUser} onEdit={onEdit} />);
    
    const editButton = screen.getByRole('button', { name: /edit/i });
    await userEvent.click(editButton);
    
    expect(onEdit).toHaveBeenCalledWith(mockUser);
  });
});
```

### Test Coverage

- Maintain minimum 80% code coverage
- Write tests for critical user flows
- Test edge cases and error scenarios
- Use meaningful test names

## Documentation

### Code Documentation

- Add JSDoc for all public functions
- Document complex business logic
- Include examples in documentation

### README Updates

Update README.md for:
- New features
- Configuration changes
- API modifications
- Setup instructions

## Pull Request Process

### Before Submitting

1. **Code Quality**
   - [ ] Code follows style guidelines
   - [ ] Tests pass locally
   - [ ] Documentation is updated
   - [ ] No sensitive data in code

2. **Testing**
   - [ ] Unit tests written
   - [ ] Integration tests pass
   - [ ] Manual testing completed
   - [ ] Accessibility checks passed

3. **Security**
   - [ ] No hardcoded secrets
   - [ ] Input validation implemented
   - [ ] XSS prevention considered
   - [ ] Authentication/authorization considered

### PR Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Breaking change
- [ ] Documentation update

## Testing
- [ ] Unit tests pass
- [ ] Integration tests pass
- [ ] E2E tests pass
- [ ] Manual testing completed

## Accessibility
- [ ] Screen reader compatible
- [ ] Keyboard navigation works
- [ ] Color contrast compliant

## Checklist
- [ ] Code follows style guidelines
- [ ] Self-review completed
- [ ] Documentation updated
- [ ] No breaking changes (or documented)
```

### Review Process

1. Automated checks must pass
2. At least one maintainer approval required
3. Address all review comments
4. Maintain clean commit history

## Issue Reporting

### Bug Reports

Use the following template for bug reports:

```markdown
**Bug Description**
Clear description of the bug

**Steps to Reproduce**
1. Step 1
2. Step 2
3. Step 3

**Expected Behavior**
What should happen

**Actual Behavior**
What actually happens

**Environment**
- OS: [e.g., Windows 10, macOS 12.0]
- Browser: [e.g., Chrome 120, Firefox 121]
- Node Version: [e.g., 20.10.0]

**Additional Context**
Any other relevant information
- Screenshots if applicable
```

### Feature Requests

```markdown
**Feature Description**
Clear description of the feature

**Problem Statement**
What problem does this solve?

**Proposed Solution**
How should this be implemented?

**Alternatives Considered**
Other approaches you thought about

**Additional Context**
Any other relevant information
- Mockups if applicable
```

## Security

If you discover a security vulnerability, please report it privately to:

- Email: security@example.com
- Do not open a public issue

See our [Security Policy](SECURITY.md) for more details.

## Getting Help

- Check existing issues and documentation
- Join our [Discord community](https://discord.gg/example)
- Create an issue for questions

## License

By contributing, you agree that your contributions will be licensed under the [MIT License](LICENSE).

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
