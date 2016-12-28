/**
 * The MIT License
 * Copyright (c) 2016 Pablo Pacheco
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.pablodomingos.graphviz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class FilesUtil {

	public static int toFile(String graficoTemp, int count) {

		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.add(graficoTemp);
		gv.addln(gv.end_graph());
		String type = "gif";
		String repesentationType = "dot";
		File out = new File("temp/" + count + "." + type); // Windows
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);

		return count + 1;

	}

	public static void generateGifAnimated(int timeToBetweenImages) {

		File dir = new File("temp");

		FilenameFilter IMAGE_FILTER = new FilenameFilter() {

			@Override
			public boolean accept(final File dir, final String name) {
				if (name.endsWith(".gif")) {
					return (true);
				}
				return (false);
			}
		};

		if (dir.isDirectory()) {
			LinkedList<BufferedImage> images = new LinkedList<>();
			
			try {
				
				int count = dir.listFiles(IMAGE_FILTER).length;
				for (int i = 0; i < count; i++) {
					images.add(ImageIO.read(new File(dir.getName()+"/"+i+".gif")));
				}
				
				
			Giffer.generateFromBI(images, "gif/graph.gif", timeToBetweenImages, true);
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void cleanDirectory(String dir) {
		File directory = new File(dir);
		if (directory.isDirectory()) {
			for (File f : directory.listFiles()) {
				f.delete();
			}
		}
	}
}
