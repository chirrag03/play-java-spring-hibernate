package models.entities;

import javax.persistence.*;

/**
 * Created by Chirrag on 21/01/18.
 */
@Entity
@Table(name = "test_table", schema = "")
public class Test {

    private Integer id;
    private String name;
    private String url;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 20)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = false, insertable = true, updatable = true, length = 2048)
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test artwork = (Test) o;

        if (id != null ? !id.equals(artwork.id) : artwork.id != null) return false;
        if (name != null ? !name.equals(artwork.name) : artwork.name != null) return false;
        return url != null ? url.equals(artwork.url) : artwork.url == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
