import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class QiagenTest {

	public static void main(String[] args) {

		int[][] inputFile1 = {
				{1, 1, 100},
				{2, 50, 100},
				{3, 500, 5000}
		};

		int[][] inputFile2 = {
				{1, 50, 150},
				{2, 150, 200}
		};

		System.out.println(Arrays.deepToString(mergeInputFiles(inputFile1, inputFile2)));

	}


	/*
	Prob 1:
	Assumptions:
	1. Each input file is 2d array with 3 as column size (chrome, start end)
	2. Intervals in an imput file are sorted according to chrome number

	Idea:
	1. Add first file content in treemap as it sorts by key which is chrome number
	2. Adding second file into map
		2.1 check if chrome is present if yes then get list and check one by one if curr interval
			overlaps if yes then create new start and end and add to ls and remove the pre interval
		2.2 if no chrome is present then just add the entire thing to map
	3. add map content to list and then converting it to return type of the method which 2d array
	 */

	public static int[][] mergeInputFiles(int[][] inputFile1, int[][] inputFile2) {
		// adding first file content to treemap
		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		for (int[] interval : inputFile1) {
			int chrome = interval[0];
			int start = interval[1];
			int end = interval[2];
			List<int[]> ls;
			if (map.containsKey(chrome)) {
				ls = map.get(chrome);
			} else {
				ls = new ArrayList<>();
			}
			ls.add(new int[]{start, end});
			map.put(chrome, ls);
		}

		System.out.println(map);
		// adding second file to map
		for (int[] interval : inputFile2) {
			int chrome = interval[0];
			int start = interval[1];
			int end = interval[2];
			int[] curr = new int[]{start, end};
			List<int[]> ls;
			if (map.containsKey(chrome)) {
				ls = map.get(chrome);
				for (int i = 0; i < ls.size(); i++) {
					int[] pre = ls.get(i);
					if (overlap(pre, curr)) {
						start = Math.min(pre[0], curr[0]);
						end = Math.max(pre[1], curr[1]);
						ls.remove(i);
						break;
					}
				}
			} else {
				ls = new ArrayList<>();
			}
			ls.add(new int[]{start, end});
			map.put(chrome, ls);
		}

		// making the list of intervals continuous for each chrome
		// and adding to res
		int j = 0;
		List<int[]> res = new ArrayList<>();
		for (int chrome : map.keySet()) {
			List<int[]> ls = map.get(chrome);
			ls.sort((a, b) -> a[0] - b[0]);
			for (int[] inter : ls) {
				res.add(new int[]{chrome, inter[0], inter[1]});
			}
		}

		// converting list to array to return
		int[][] ans = new int[res.size()][3];
		for (int[] entry : res) {
			ans[j][0] = entry[0];
			ans[j][1] = entry[1];
			ans[j][2] = entry[2];
			j++;
		}
		return ans;
	}

	private static boolean overlap(int[] i1, int[] i2) {
		return (i1[0] <= i2[1] && i2[0] <= i1[1]);
	}
}

	/*
	Prob 3:

	Units test for :
	1. getDiseaseInfoByName(String name)
		1.1 for both valid and invalid input
	2. getDiseasesForDataset (int datasetId)
		2.1 for both valid and invalid input

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
}


public class DiseaseInfoService {
	static Map<String, Integer> name2Id = new HashMap<String, Integer>();
	static Map<Integer, DiseaseInfo> id2Info = new HashMap<Integer, DiseaseInfo>();

	static {
		AnnotationFactory.initDiseaseInfo(name2Id, id2Info);
	}

	private DocumentDao documentDao;

	public DiseaseInfoService() {
		documentDao = new FileSystemDocumentDao();
	}

	public DiseaseInfo getDiseaseInfoByName(String name) {
		Integer diseaseId = name2Id.get(name);
		return (diseaseId != null) ? id2Info.get(diseaseId) : null;
	}

	// changed return set of Disease to DiseaseInfo
	public Set<DiseaseInfo> getDiseasesForDataset(int datasetId) throws ServiceException {
		try {
			// changed set of Disease to DiseaseInfo
			Set<DiseaseInfo> diseases = new HashSet<DiseaseInfo>();
			DataSet ds = documentDao.getDocument(datasetId);
			if (ds.getType() == DataSet.Type.VCF) {
				for (int i = 0; i < ds.getRowCount; i++) {
					DataSetRow row = ds.getRow(i);
					String name = row.getColumn(3);
					Integer diseaseId = name2Id.get(name);
					// changed datasetId to diseaseId to get disease info from Id2info map
					diseases.add(id2Info.get(diseaseId));
				}
			} else if (ds.getType() == DataSet.Type.MSF) {
				for (int i = 0; i < ds.getRowCount; i++) {
					DataSetRow row = ds.getRow(i);
					String name = row.getColumn(10);
					Integer diseaseId = name2Id.get(name);
					// changed datasetId to diseaseId to get disease info from Id2info map
					diseases.add(id2Info.get(diseaseId));
				}
			}
			return diseases;
		} catch (Exception e) {
			throw new ServiceException(“Error processing dataset.”, e);
		}
	}

	public void setDocumentDao(DocumentDao xmlDocumentDao) {
		// changed documenetDao to xmlDocumentDao
		this.documentDao = xmlDocumentDao;
	}
}

	 */

/*
Prob 4:


public class CachedServlet extends HttpServlet {
	private int cacheHits;
	private int lastId;
	private String lastResult;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException {

		final String[] result = {null};
		int id = extractFromRequest(request);
		if ((id == lastId) && (lastResult != null)) {
			result[0] = lastResult;
			cacheHits++;
		} else {
			final AsyncContext asyncContext = request.startAsync(request, response);
			try {
				// basically creating a worker thread to do the heavy work
				// making the get request asynchronous making it more responsive
				new Thread(() -> {
					result[0] = doTimeConsumingCalculation(id);
					lastId = id;
					lastResult = result[0];
				}).start();
				asyncContext.complete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		encodeIntoResponse(response, result[0]);
	}
}
 */

