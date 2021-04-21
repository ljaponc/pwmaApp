package me.fit.project.service.api;

import java.util.List;

import me.fit.project.model.Strip;

public interface StripService {
	public void addStrip(Strip s) throws Exception;

	public Strip findById(Long id);

	public List<Strip> getAllStripovi();

	public List<Strip> getByName(String nameP);
}
