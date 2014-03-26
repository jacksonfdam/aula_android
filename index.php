<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
	<head>
		<title>Integração WebView Android e Javascript Web</title>
	</head>
	
	<body>
		<h2>Olá <?php echo $_GET['apelido']; ?></h2>
		<h3>Vinculação WebView e Javascript</h3>
		
		<form id="form">
			<input type="text" id="nome" placeholder="*Nome" />
			<br />
			<input type="text" id="email" placeholder="*Email" />
			<br />
			<input type="password" id="senha" placeholder="*Senha" />
			
			<br /><br />
			<button type="submit">Enviar</button>
		</form>
		
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script type="text/javascript">
			
			$('#form').submit(function(e){
				e.preventDefault();
				
				var nome = $('#nome').val();
				var email = $('#email').val();
				var senha = $('#senha').val();
				
				ExemploWebView.getForm(nome, email, senha);
			});
			
		</script>
	</body>
</html>