package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class TAFeuerkriegerteam extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkRochen;

	public TAFeuerkriegerteam() {
		name = "Feuerkriegerteam";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Feuerkrieger", 6, 12, 10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/Feuerkriegerteam.gif"));
		

		seperator(5);

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Sturmgewehre", "Pulssturmgewehre", squad.getModelle(), 0));
		seperator(5);
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Photonengranaten", 1));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "EMP-Granaten", 3));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "TAInfanterieKammer", "Upgrade zum Shas'ui");
		rkBoss.initKammer(true, true);
		add(rkBoss);

		seperator();

		rkRochen = new RuestkammerStarter(ID, randAbstand, cnt, "TATeufelsrochenKammer", "Teufelsrochen");
		rkRochen.initKammer();
		add(rkRochen);
		BuildaHQ.addToInformationVector("TAFeuerkrieger", 1);
		
		complete();
	}

	@Override
    public void deleteYourself() {
		BuildaHQ.addToInformationVector("TAFeuerkrieger", -1);
        BuildaHQ.refreshEntries(3);
        super.deleteYourself();
    }
	
	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());

		int empPrice = squad.getModelle() * 3;
		if(rkBoss.isSelected() && rkBoss.getKammer().getSpecialValue().equals("TRUE")) {
			empPrice = empPrice - 3;
		}
		o3.setPreis(empPrice);
		o2.setPreis(squad.getModelle() * 1);

		rkRochen.getPanel().setLocation(
			(int) rkRochen.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);
	}
	
}
