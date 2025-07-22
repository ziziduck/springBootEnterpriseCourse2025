package com.example.demo1.bean;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUser1 {
	@NotNull(message = "NormalUser1 name may not be null")
	private String name;
}