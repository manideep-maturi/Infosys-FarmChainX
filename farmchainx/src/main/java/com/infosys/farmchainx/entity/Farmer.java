package com.infosys.farmchainx.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFarmLocation() {
		return farmLocation;
	}

	public void setFarmLocation(String farmLocation) {
		this.farmLocation = farmLocation;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public FarmerStatus getStatus() {
		return status;
	}

	public void setStatus(FarmerStatus status) {
		this.status = status;
	}

	@OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String farmLocation;

    private String cropType;

    @Enumerated(EnumType.STRING)
    private FarmerStatus status;

    // Getters and Setters
}
