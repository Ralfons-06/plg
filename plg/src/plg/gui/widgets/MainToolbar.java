package plg.gui.widgets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import plg.gui.controller.ApplicationController;
import plg.gui.util.collections.ImagesCollection;

/**
 * This widget contains the main toolbar of the application
 * 
 * @author Andrea Burattin
 */
public class MainToolbar extends JToolBar {

	private static final long serialVersionUID = -2290088626676975817L;

	private JButton newProcess = new JButton("New Process", ImagesCollection.ICON_NEW);
	private JButton newMultipleProcess = new JButton("Multiple Process Generator", ImagesCollection.ICON_NEW);
	private JButton openProcess = new JButton("Open", ImagesCollection.ICON_OPEN);
	private JButton saveProcess = new JButton("Save As...", ImagesCollection.ICON_SAVE);
	private JButton saveAllProcesses = new JButton("Save All As...", ImagesCollection.ICON_SAVE);
	private JButton generateLog = new JButton("Generate Log", ImagesCollection.ICON_LOG);
	private JButton generateAllLogs = new JButton("Generate ALl Log", ImagesCollection.ICON_LOG);
	private JButton generateStream = new JButton("Stream", ImagesCollection.ICON_STREAM);
	private JToggleButton showConsole = new JToggleButton("", ImagesCollection.ICON_CONSOLE);
	
	public MainToolbar() {
		setFloatable(false);
		setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		add(newProcess);
		add(openProcess);
		add(saveProcess);
		add(saveAllProcesses);
		add(newMultipleProcess);
		add(Box.createHorizontalGlue());
		add(generateAllLogs);
		add(generateLog);
		add(generateStream);
		add(Box.createHorizontalStrut(20));
		add(showConsole);
		
		registerListeners();
		setProcessSelected(false);
	}
	
	/**
	 * Method to set the selection of the "show console" button
	 * 
	 * @param visible
	 */
	public void setShowConsoleSelected(boolean visible) {
		showConsole.setSelected(visible);
	}
	
	/**
	 * Method to set internal button statuses, depending on whether the
	 * application is showing a process or not.
	 * 
	 * @param processVisualized indicating whether the application is
	 * visualizing a process or not
	 */
	public void setProcessSelected(boolean processVisualized) {
		saveProcess.setEnabled(processVisualized);
		generateLog.setEnabled(processVisualized);
		generateStream.setEnabled(processVisualized);
	}
	
	/**
	 * Method to register the button listeners
	 */
	private void registerListeners() {
		newProcess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().processes().randomProcess();
			}
		});

		newMultipleProcess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().processes().randomProcess_mod();
			}
		});
		
		openProcess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().processes().openProcess();
			}
		});
		
		saveProcess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().processes().saveProcess();
			}
		});

		saveAllProcesses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().processes().saveAllProcesses();
			}
		});
		
		generateLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().log().generateLog();
			}
		});

		generateAllLogs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().log().generateAllLog();
			}
		});

		generateStream.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().log().generateStream();
			}
		});
		
		showConsole.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplicationController.instance().console().setConsoleVisibility(showConsole.isSelected());
			}
		});
	}
}
