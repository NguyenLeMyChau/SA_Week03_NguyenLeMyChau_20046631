package vn.edu.iuh.fit.jdepend;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import jdepend.framework.JavaPackage;
import jdepend.framework.PackageFilter;
import java.io.PrintWriter;

public class JDepend {
	public static void main(String[] args) throws IOException {
		jdepend.framework.JDepend d = new jdepend.framework.JDepend();
		d.addDirectory(
				"C:\\Users\\CHAU\\Desktop\\SoftwareArchitecture\\Week03\\SA_Week03_NguyenLeMyChau_20046631");
		Collection<JavaPackage> cols = d.analyze();
		cols.forEach(pkg -> {
			System.out.printf("Pakage %s, Ca= %d; Ce=%d;\n", pkg.getName(), pkg.getAfferents().size(),
					pkg.getEfferents().size());
		});

		try (PrintWriter out = new PrintWriter(new FileOutputStream("results.xml"))) {
			jdepend.xmlui.JDepend xml = new jdepend.xmlui.JDepend(out);
			xml.addDirectory("C:\\Users\\CHAU\\Desktop\\SoftwareArchitecture\\Week03\\SA_Week03_NguyenLeMyChau_20046631");
			PackageFilter f = PackageFilter.all();
			// f.including("vn.edu.iuh");
			f.accept("vn.edu");
			f.excluding("org");
			xml.setFilter(f);
			xml.analyze();
		}

	}
}
