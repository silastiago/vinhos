insert into grupo (codigo, nome) values (1, 'CADASTRO');
insert into grupo (codigo, nome) values (2, 'CONSULTA');
insert into grupo (codigo, nome) values (3, 'FULL');

insert into permissao (codigo, nome) values (1, 'LISTAR');
insert into permissao (codigo, nome) values (2, 'ADICIONAR');
insert into permissao (codigo, nome) values (3, 'REMOVER');

insert into usuario (codigo, nome, email, senha) values (1, 'SILAS', 'silastiagoo@gmail.com', '202cb962ac59075b964b07152d234b70');


insert into usuario_grupo (codigo_usuario, codigo_grupo) values (1, 1);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,1);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,2);


insert into usuario_grupo (codigo_usuario, codigo_grupo) values (2, 2);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,1);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,2);


insert into usuario_grupo (codigo_usuario, codigo_grupo) values (3, 3);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,1);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,2);
INSERT INTO grupo_permissao (codigo_grupo, codigo_permissao) VALUES (1,3);

