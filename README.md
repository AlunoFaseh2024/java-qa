# java-qa

## Atividade/Trabalho sobre testes de caixa branca e caixa preta

**Para os testes a seguir, foi usado as extensões HttpBook e HttpYac e o programa Advance REST Client by MuleSoft. Com as extensões instaladas, pode-se confir o arquivo auth.http**

### O plano de teste para testes de caixa preta:
- **Testar autenticação:**
	- Fazer autenticação normalmente;
		- Resultados: Usar o Bearer {{token}} como método de autenticação funcionou como o esperado.
		
	- Usar token não gerado pelo sistema ou expirado na hora de usar um método;
		- Resultados: Usar um token que não foi gerado pelo sistema resulta no erro 403.


- **Testar método POST:**
	- Verificar se é possível criar um novo usuário; (POST -> /auth/user)
		- Resultados: OK.
		
				{
				"token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgT2ZpY2luYSBKYXZhIiwic3ViIjoiMTIwIiwiaWF0IjoxNzQ0NTAxOTYyLCJleHAiOjE3NDQ1ODgzNjJ9.no8TECRLegvFiuJwBIbdLlUXjlyKXSFH74srU2__lps",
				"tipo": "Bearer",
				"roles": "ADMIN"
				}

		
	- Verificar se é possível inserir valores absurdos; (POST -> /auth/user)
		- Resultados: Foi possível. Suporta acima de 100 caracteres, porém testando 512 já não foi mais possível.
			
			
	- Verificar se é possível criar dois usuários iguais;
		- Resultados: Não foi possível.
		
					HTTP/1.1 403
					Forbidden
					vary:
					Origin, Access-Control-Request-Method, Access-Control-Request-Headers
					content-length: 0
					date: Sun, 13 Apr 2025 00:09:35 GMT
					connection:
					close
	
	
	- Verificar se é possível criar usuário com valores nulos;
		- Resultados: Sim, foi possível.
		
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

	- Tentar recuperar informação de usuários; (GET -> /user)
		- Resultados: Funciona.
		
				[
				{
				"id": 95,
				"nome": "emily",
				"email": "emilycarolina@gmail.com",
				"password": "$2a$10$jhf/LtsRj2GucOhcrxNLMO7uFf95jdz/u8zPREcoru95Swh/5nIIe",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "emilycarolina@gmail.com"
				},
				{
				"id": 96,
				"nome": "gustavo",
				"email": "gustavo@gmail.comcom",
				"password": "$2a$10$oElePmcEbZvHnu6RdPvyie2NQbOODL2i9B1uWTKyfodE4LFxHl1HK",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "gustavo@gmail.comcom"
				},
				{
				"id": 102,
				"nome": "arthur",
				"email": "arthur@gmail.com",
				"password": "$2a$10$HPwyg9lkuN4F3DngPtpHAOde5ZguB48M8vedFOkKkQPNvJFFBr9yq",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "arthur@gmail.com"
				},
				{
				"id": 103,
				"nome": "gabriel",
				"email": "gabriel@gmail.com",
				"password": "$2a$10$ID8Hz98obvsrypJloJI8Ueqo82yL7IHD6mzrYbOXztglYxe8jOaTu",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "gabriel@gmail.com"
				},
				{
				"id": 106,
				"nome": "emily",
				"email": "emiily@gmail.com",
				"password": "$2a$10$.LyBwrT/7MCQu0G7CaNjCOZ4TBAojc0i/nhnt9XTw7SbRKp/WQrja",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "emiily@gmail.com"
				},
				{
				"id": 112,
				"nome": "emily carolina",
				"email": "emilyc@gmail.com",
				"password": "$2a$10$RbxJhWgo3PU1aok753gMn.5U57f2FXIM6xphHrvWh44.gTvCQW0Fu",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "emilyc@gmail.com"
				},
				{
				"id": 113,
				"nome": "Cleber Leão",
				"email": "cleber@configs.com.br",
				"password": "$2a$10$9KuAHBQ8/WnmvnXVbwp3AeJTi/xGR4qOvkNWVf1OjOHgnDftIGz0G",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "cleber@configs.com.br"
				},
				{
				"id": 114,
				"nome": "Faseh",
				"email": "aula_qa@faseh.com.br",
				"password": "$2a$10$t9hgmu/2G05mAXmdkWF.cepmrsvV.v7Qmc5srl7doY3KXbsZ3XjjO",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "aula_qa@faseh.com.br"
				},
				{
				"id": 115,
				"nome": "Paulo Daniel Ferreira de Jesus",
				"email": "paulodaniel1169@hotmail.com",
				"password": "$2a$10$dAsV9LqEeJnsxnfCyoMlnuxbiFXKs/4MgCR9RmwfxCo.pSyxvTjPy",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "paulodaniel1169@hotmail.com"
				},
				{
				"id": 119,
				"nome": "Ana Clara",
				"email": "ana@clara.com.br",
				"password": "$2a$10$lsv6NGX.KK1dYHJu0iIGueBlZE98wdVcyYIUy0HTw7bcDmNPEFZMm",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "ana@clara.com.br"
				},
				{
				"id": 120,
				"nome": "rafael",
				"email": "rafael@faseh.edu.br",
				"password": "$2a$10$CnmvkF19ixDq/ZWiLvp/w.hkh9Qk66bjxRfGv/qRSHrv2QWQ9iSp6",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "rafael@faseh.edu.br"
				},
				{
				"id": 121,
				"nome": "xpvl47w76oa4fdbr7m6zfmosog2uevsswapydj9sc5ma05jor3vwih112acemtah8nwee8f0luxki07d49yqr2l24ahj138wwr1x9n73woija54wn1stjjjf4athhr8f",
				"email": "xpvl47w76oa4fdbr7m6zfmosog2uevsswapydj9sc5ma05jor3vwih112acemtah8nwee8f0luxki07d49yqr2l24ahj138wwr1x9n73woija54wn1stjjjf4athhr8f@faseh.edu.br",
				"password": "$2a$10$BbPwQS53AahR8X7GzWcYvOan4JVf2tRCM6gQ5FH2BgXZi01BM7Ofq",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "xpvl47w76oa4fdbr7m6zfmosog2uevsswapydj9sc5ma05jor3vwih112acemtah8nwee8f0luxki07d49yqr2l24ahj138wwr1x9n73woija54wn1stjjjf4athhr8f@faseh.edu.br"
				},
				{
				"id": 122,
				"nome": "ge33c7gbohdqypovcxezni011m9g6jp4gced3uwlmvek8vyymfndu5val8up4ldjbq7bmtqvktb8h8pfzz0g3mj0l8f3yuzsi6z0rj0gbpm4tms",
				"email": "rafael1@faseh.edu.br",
				"password": "$2a$10$KXG6p6pCWq5kBcCNXlFLkO0hZoseUx2MRst2zb9rjxlcXqvdbooau",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "rafael1@faseh.edu.br"
				},
				{
				"id": 124,
				"nome": "",
				"email": "",
				"password": "$2a$10$ULPC6rlj5DWvn6nHGhE2FO2kcA8s7XAHj31DsW3k.MiQJkHe3Dp5i",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": ""
				},
				{
				"id": 126,
				"nome": "AZUL",
				"email": "azul@cor.es",
				"password": "$2a$10$ef50/6kxSk5aZO3rOhoSVO2Qp8Cbo0aBrMLfp2yDBLpLcU5OLKHpi",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "azul@cor.es"
				}
				]
			
		
	- Tentar recuperar informação de usuários; (GET -> /user/id)		
		- Resultados: Funciona.
			
				{
				"id": 126,
				"nome": "AZUL",
				"email": "azul@cor.es",
				"password": "$2a$10$ef50/6kxSk5aZO3rOhoSVO2Qp8Cbo0aBrMLfp2yDBLpLcU5OLKHpi",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": "azul@cor.es"
				}
				
				
- **Testar método PUT:**
	- Tentar atualizar a senha do usuário;
		- Resultados: Erro, não funcionou.
			
				{"timestamp":1744558700032,"status":500,"error":"Internal Server Error","trace":"org.springframework.dao.InvalidDataAccessApiUsageException: Unknown entity: com.cleberleao.oficina.springboot.dto.UserDto; nested exception is java.lang.IllegalArgumentException: Unknown entity: com.cleberleao.oficina.springboot.dto.UserDto\r\n\tat org.springframework.orm.jpa.EntityManagerFactoryUtils.convertJpaAccessExceptionIfPossible(EntityManagerFactoryUtils.java:374)\r\n\tat org.springframework.orm.jpa.vendor.HibernateJpaDialect.translateExceptionIfPossible(HibernateJpaDialect.java:235)\r\n\tat org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.translateExceptionIfPossible(AbstractEntityManagerFactoryBean.java:551)\r\n\tat org.springframework.dao.support.ChainedPersistenceExceptionTranslator.translateExceptionIfPossible(ChainedPersistenceExceptionTranslator.java:61)\r\n\tat org.springframework.dao.support.DataAccessUtils.translateIfNecessary(DataAccessUtils.java:242)\r\n\tat org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:152)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n\tat org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:174)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n\tat org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n\tat org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:241)\r\n\tat com.sun.proxy.$Proxy115.save(Unknown Source)\r\n\tat com.cleberleao.oficina.springboot.service.UserService.alterar(UserService.java:27)\r\n\tat com.cleberleao.oficina.springboot.controller.UserController.alterar(UserController.java:26)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)\r\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1072)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:965)\r\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\r\n\tat org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:558)\r\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:623)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:209)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:337)\r\n\tat org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:115)\r\n\tat org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:81)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:122)\r\n\tat org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:116)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)\r\n\tat org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:109)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat com.cleberleao.oficina.springboot.config.security.AutenticacaoViaTokenFilter.doFilterInternal(AutenticacaoViaTokenFilter.java:41)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)\r\n\tat org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)\r\n\tat org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:112)\r\n\tat org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:82)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:221)\r\n\tat org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:186)\r\n\tat org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:354)\r\n\tat org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:267)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\r\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\r\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:481)\r\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:130)\r\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\r\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\r\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\r\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:390)\r\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\r\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:926)\r\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1791)\r\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\r\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n\tat java.lang.Thread.run(Thread.java:750)\r\nCaused by: java.lang.IllegalArgumentException: Unknown entity: com.cleberleao.oficina.springboot.dto.UserDto\r\n\tat org.hibernate.internal.SessionImpl.fireMerge(SessionImpl.java:836)\r\n\tat org.hibernate.internal.SessionImpl.merge(SessionImpl.java:816)\r\n\tat sun.reflect.GeneratedMethodAccessor53.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.springframework.orm.jpa.ExtendedEntityManagerCreator$ExtendedEntityManagerInvocationHandler.invoke(ExtendedEntityManagerCreator.java:362)\r\n\tat com.sun.proxy.$Proxy111.merge(Unknown Source)\r\n\tat sun.reflect.GeneratedMethodAccessor53.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:315)\r\n\tat com.sun.proxy.$Proxy111.merge(Unknown Source)\r\n\tat org.springframework.data.jpa.repository.support.SimpleJpaRepository.save(SimpleJpaRepository.java:669)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.springframework.data.repository.core.support.RepositoryMethodInvoker$RepositoryFragmentMethodInvoker.lambda$new$0(RepositoryMethodInvoker.java:289)\r\n\tat org.springframework.data.repository.core.support.RepositoryMethodInvoker.doInvoke(RepositoryMethodInvoker.java:137)\r\n\tat org.springframework.data.repository.core.support.RepositoryMethodInvoker.invoke(RepositoryMethodInvoker.java:121)\r\n\tat org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:530)\r\n\tat org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:286)\r\n\tat org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:640)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n\tat org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:164)\r\n\tat org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:139)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n\tat org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:76)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n\tat org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123)\r\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:388)\r\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\r\n\tat org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137)\r\n\t... 95 more\r\nCaused by: org.hibernate.MappingException: Unknown entity: com.cleberleao.oficina.springboot.dto.UserDto\r\n\tat org.hibernate.metamodel.internal.MetamodelImpl.entityPersister(MetamodelImpl.java:715)\r\n\tat org.hibernate.internal.SessionImpl.getEntityPersister(SessionImpl.java:1653)\r\n\tat org.hibernate.event.internal.DefaultMergeEventListener.onMerge(DefaultMergeEventListener.java:152)\r\n\tat org.hibernate.event.internal.DefaultMergeEventListener.onMerge(DefaultMergeEventListener.java:74)\r\n\tat org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)\r\n\tat org.hibernate.internal.SessionImpl.fireMerge(SessionImpl.java:829)\r\n\t... 128 more\r\n","message":"Unknown entity: com.cleberleao.oficina.springboot.dto.UserDto; nested exception is java.lang.IllegalArgumentException: Unknown entity: com.cleberleao.oficina.springboot.dto.UserDto","path":"/user"}
				
				
	- Tentar atualizar usuário que não existe;
		- Resultados: Erro, não funcionou
		
- **Testar método DELETE:**
	- Tentar apagar usuário; (DELETE -> /user/id)
		- Resultados: Sucesso. (OBS: necessita do token no bearer)
					
				{
				"id": 124,
				"nome": "",
				"email": "",
				"password": "$2a$10$ULPC6rlj5DWvn6nHGhE2FO2kcA8s7XAHj31DsW3k.MiQJkHe3Dp5i",
				"enabled": true,
				"authorities": null,
				"accountNonExpired": true,
				"accountNonLocked": true,
				"credentialsNonExpired": true,
				"username": ""
				}
					
		
	- Tentar apagar usuário inexistente;
		- Resultados: OK, erro como esperado.
		
				{
				"timestamp": 1744558320228,
				"status": 500,
				"error": "Internal Server Error",
				"trace": "java.util.NoSuchElementException: No value present\r\n\tat java.util.Optional.get(Optional.java:135)\r\n\tat com.cleberleao.oficina.springboot.service.UserService.apagar(UserService.java:32)\r\n\tat com.cleberleao.oficina.springboot.controller.UserController.apagar(UserController.java:31)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)\r\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)\r\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1072)\r\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:965)\r\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\r\n\tat org.springframework.web.servlet.FrameworkServlet.doDelete(FrameworkServlet.java:931)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:561)\r\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\r\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:623)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:209)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:337)\r\n\tat org.springframework.security.web.access.intercept.FilterSecurityInterceptor.invoke(FilterSecurityInterceptor.java:115)\r\n\tat org.springframework.security.web.access.intercept.FilterSecurityInterceptor.doFilter(FilterSecurityInterceptor.java:81)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:122)\r\n\tat org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:116)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:126)\r\n\tat org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:81)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:109)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:149)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat com.cleberleao.oficina.springboot.config.security.AutenticacaoViaTokenFilter.doFilterInternal(AutenticacaoViaTokenFilter.java:41)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:103)\r\n\tat org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:89)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)\r\n\tat org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:112)\r\n\tat org.springframework.security.web.context.SecurityContextPersistenceFilter.doFilter(SecurityContextPersistenceFilter.java:82)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:55)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.springframework.security.web.FilterChainProxy$VirtualFilterChain.doFilter(FilterChainProxy.java:346)\r\n\tat org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:221)\r\n\tat org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:186)\r\n\tat org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:354)\r\n\tat org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:267)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\r\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:178)\r\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:153)\r\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\r\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\r\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:481)\r\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:130)\r\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\r\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\r\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\r\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:390)\r\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\r\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:926)\r\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1791)\r\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)\r\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\r\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\r\n\tat java.lang.Thread.run(Thread.java:750)\r\n",
				"message": "No value present",
				"path": "/user/124"
				}		
		
#### ETC

Foi descoberto que ao dar POST no caminho de criação de usuário, porém inserindo um ID já existente, acaba atualizando/sobrescrevendo o usuário antigo com o novo.