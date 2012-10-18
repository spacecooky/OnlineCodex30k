package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SMTaktischerTrupp extends SM_CanHaveValthexHellfireRounds {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;
	OptionsEinzelUpgrade apo;
        
        boolean siegeAssaultForce;
        
        OptionsEinzelUpgrade mantlets;

	public SMTaktischerTrupp() {
		name = "Taktischer Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

                siegeAssaultForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);
                
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 16);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMTaktischerTrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
        
                add(hellfire = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Höllenfeuer-Geschoße", 0));
                hellfire.setToolTipText("Werden durch Armenneus Valthex frei geschaltet. Maximal 1x pro Armee wählbar.");

		seperator();
                
        if(siegeAssaultForce) {
            
            add(mantlets = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Siege Mantlets", 50));
        
            seperator();
        }
        
        add(apo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "kammer", "Apothecarius", 10));
        		
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(true, true, true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

                if(!siegeAssaultForce) {

                    seperator();

                    rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
                    rkPod.initKammer(false);
                    rkPod.setButtonText("Landungskapsel");
                    rkPod.setSeperator(0);
                    add(rkPod);

                }

		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("SMLordHighCommanderCarabCulln")>0){
			apo.setAktiv(true);
			rkBoss.setAktiv(!apo.isSelected());
			if(rkBoss.isAktiv() && !rkBoss.isSelected()){
				rkBoss.setSelected(true);
			}
		}else{
			apo.setAktiv(false);
			rkBoss.setAktiv(true);
			if(!rkBoss.isSelected()) rkBoss.setSelected(true);
		}
        
		o1.setAktiv(squad.getModelle() == 10);
		o2.setAktiv(squad.getModelle() == 10);
        
		if(siegeAssaultForce) {
                    rkTransport.setAktiv(!mantlets.isSelected());
                    mantlets.setAktiv(!rkTransport.isSelected());
                } else {
                    rkTransport.setAktiv(!rkPod.isSelected());
                    rkPod.setAktiv(!rkTransport.isSelected() && squad.getModelle() == 10);
                }
        
        super.checkHellfireRounds();
	}

}
