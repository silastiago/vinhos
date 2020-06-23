insert into grupo (codigo, nome) values (1, 'ADMINISTRADORES');

insert into Permissao (codigo, nome) values (1, 'LISTAR');
insert into Permissao (codigo, nome) values (2, 'ADICIONAR');
insert into Permissao (codigo, nome) values (3, 'REMOVER');
insert into Permissao (codigo, nome) values (4, 'ADMIN');


insert into Permissao (nome) values ( 'LISTAR');
insert into Permissao (nome) values ( 'ADICIONAR');
insert into Permissao (nome) values ( 'REMOVER');
insert into Permissao ( nome) values ( 'ADMIN');

insert into usuario (codigo, nome, email, senha) values (1, 'TESTE', 'teste@gmail.com', '202cb962ac59075b964b07152d234b70');


insert into usuario_grupo (codigo_usuario, codigo_grupo) values (1, 1);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,4);
