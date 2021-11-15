/*
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class DiseaseInfoServiceTest {

	DiseaseInfoService service;

	@BeforeEach
	void setUp() {
		service = new DiseaseInfoService();
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void getDiseaseInfoByName() {
		String name = "cancer";
		String description = "xyz";
		// for simplicity assuming id is an int type but can be long
		int id = 3;
		DiseaseInfo diseaseInfo = service.getDiseaseInfoByName(name);
		// assuming DiseaseInfo class has some attributes such as
		// diseaseId, and description
		// checking if ids and descriptions match
		Assert.assertEquals(diseaseInfo.id, id);
		Assert.assertEquals(diseaseInfo.name, name);
		Assert.assertEquals(diseaseInfo.description, description);
		// if attritubes of the class are known
		// we can directly check for object equality by passing expected and actual objects of diseaseInfo
	}

	@Test
	void getDiseasesForDataset() {
		int datasetId = 2;
		Set<DiseaseInfo> expectedSet = new HashSet<DiseaseInfo>();
		// assuming we know some objects of DiseaseInfo and are added to
		// the above set
		Set<DiseaseInfo> actualSet = service.getDiseasesForDataset(datasetId);
		Assert.assertEquals(expectedSet.size(), actualSet.size());
	}

	@Test
	void setDocumentDao() {
	}
}*/
