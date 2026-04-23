package studyingspring.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

//create table livro(
//	id uuid not null primary key,
//	isbn varchar(20) not null,
//	titulo varchar(150) not null,
//	data_publicacao date not null,
//	genero varchar(30) not null,
//	preco numeric(18,2),
//	id_autor uuid not null references autor(id)
//	constraint chk_genero check (genero in ('FICCAO', 'FANTASIA', 'MISTERIO', 'ROMANCE', 'BIOGRAFIA', 'CIENCIA'))
//)

@Entity
@Table(name = "livro", schema = "public")
@Data
public class Livro {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate data_publicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco", length = 30, nullable = false, precision = 18, scale = 2)
    private double preco;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

}
