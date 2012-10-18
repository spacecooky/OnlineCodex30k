package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class ORNachtgoblinSquigherde extends Eintrag {

	AnzahlPanel squad;
	AnzahlPanel squad2;
	
	public ORNachtgoblinSquigherde() {
		name = BuildaHQ.translate("Nachtgoblin-Squigherde") + "\n";
		grundkosten = 10;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Nachtgoblin Treiba") + "\n", 1, 100, 3);
		squad.setGrundkosten(-10);
		add(squad);
		
		squad2 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Squig"), BuildaHQ.translate("Squigs"), 1, 100, 8);
		squad2.setGrundkosten(0);
		add(squad2);
		
		seperator(60);

		complete();
	}

	@Override
	public void refreshen() {	
		int mindAnz = squad2.getModelle()/3;
		if (mindAnz > squad.getModelle() ){
			setFehlermeldung(mindAnz + "+ " + BuildaHQ.translate("Nachtgoblin Treiba"));
		} else {
			setFehlermeldung("");
			
			if ( squad2.getModelle() + squad.getModelle() < 10 ) {
				setFehlermeldung(BuildaHQ.translate("Einheitengröße") + ": " +  10 + "+");
			} else {
				setFehlermeldung("");
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		
		ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);			
		ico.setLocation((270 - (ico.getSize().width - 100) / 2), 60);
		panel.add(ico);	*/	
	}
}
