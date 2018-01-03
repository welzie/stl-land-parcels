package mil.nga.gisdevops.models;

import javax.persistence.*;

/**
 * Created by mikemenne on 1/2/18.
 */

@Entity
public class Parcel {

    public Parcel() {
        super();
    }

    public Parcel(String plotName) {
        super();
        this.plotName = plotName;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="plotName")
    private String plotName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlotName() {
        return plotName;
    }

    public void setPlotName(String plotName) {
        this.plotName = plotName;
    }
}
