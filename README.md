# java-qa

## Atividade/Trabalho sobre testes de caixa branca e caixa preta

**Para os testes a seguir, foi usado a extensão HttpBook e HttpYac, com as extensões instaladas, pode-se confir o arquivo auth.http**

### O plano de teste para testes de caixa preta:
- **Testar autenticação:**
	- Usar token diferente ou expirado na hora de usar um método;
	- Fazer autenticação normalmente;

- **Testar método POST:**
	- Verificar se é possível criar um novo usuário;(POST -> /auth/user)
		Resultados:
		
			{
			"token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgT2ZpY2luYSBKYXZhIiwic3ViIjoiMTIwIiwiaWF0IjoxNzQ0NTAxOTYyLCJleHAiOjE3NDQ1ODgzNjJ9.no8TECRLegvFiuJwBIbdLlUXjlyKXSFH74srU2__lps",
			"tipo": "Bearer",
			"roles": "ADMIN"
			}
		
	- Verificar se é possível inserir valores absurdos;(POST -> /auth/user)
		Resultados:
		
			Suporta acima de 100 caracteres, porém testando 512 já não foi possível.
			
	- Verificar se é possível criar dois usuários iguais;
		Resultados:
			
			Não foi possível: 
					HTTP/1.1 403
					Forbidden
					vary:
					Origin, Access-Control-Request-Method, Access-Control-Request-Headers
					content-length: 0
					date: Sun, 13 Apr 2025 00:09:35 GMT
					connection:
					close
	
	
	- Verificar se é possível criar usuário com valores nulos;
		Resultados:
		
			Sim, foi possível:
				{
				"id": 124,
				"nome": "",
				"email": "",
				"password": "$2a$10$ULPC6rlj5DWvn6nHGhE2FO2kcA8s7XAHj31DsW3k.MiQJkHe3Dp5i",
				"enabled": true,
				"username": "",
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true
				}
				
- **Testar método GET:**
	- Tentar recuperar informação de usuário;
		Resultados:
		
- **Testar método PUT:**
	- Tentar atualizar a senha do usuário;
	- Tentar atualizar usuário que não existe;
	
- **Testar método DELETE:**
	- Tentar apagar usuário;
	- Tentar apagar usuário inexistente;