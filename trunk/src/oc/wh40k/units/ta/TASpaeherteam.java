package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class TASpaeherteam extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelZaehler o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkRochen;

	public TASpaeherteam() {
		name = "Späherteam";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Späher", 4, 8, 12);
		add(squad);
        
        BuildaHQ.addToInformationVector("TA2006Spaeherteam", 1);

		add(ico = new oc.Picture("oc/wh40k/images/Spaeherteam.gif"));

		seperator(5);

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "MBG", "Massebeschleuniger-Gewehr", 3, 10));
		seperator(5);
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Photonengranaten", 1));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "EMP-Granaten", 3));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "TAInfanterieKammer", "Upgrade zum Shas'ui");
		rkBoss.initKammer(false, true);
		add(rkBoss);

		seperator();

		rkRochen = new RuestkammerStarter(ID, randAbstand, cnt, "TATeufelsrochenKammer", "Teufelsrochen");
		rkRochen.initKammer();
		add(rkRochen);

		complete();
	}

	@Override
	public void refreshen() {
		int empPrice = squad.getModelle() * 3;
		if(rkBoss.isSelected() && rkBoss.getKammer().getSpecialValue().equals("TRUE")) {
			empPrice = empPrice - 3;
		}
		o3.setPreis(empPrice);
		o2.setPreis(squad.getModelle() * 1);

		rkRochen.setAbwaehlbar(false);
		rkRochen.getPanel().setLocation(
			(int) rkRochen.getPanel().getLocation().getX(),
			(int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height + 5
		);

        // O'Shova Sonderregel beachten
        int currentUnitCount = BuildaHQ.getCountFromInformationVector("TA2006Spaeherteam");
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova && currentUnitCount > 1) setFehlermeldung("0-1 wgegen O'Shova");
        else setFehlermeldung("");
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("TA2006Spaeherteam", -1);
    }
    
}
